const express = require("express");
const router = express.Router();
const taskModel = require("../models/taskModel");


// fetching task (GET)
router.get("/task", async (req, res) => {
    try {
        const task = await taskModel.find();
        res.status(200).json(task);
    } catch(Error) {
        res.status(400).json({message: "not fetching task " + Error});
    }
});


// creating task (POST)
router.post("/task", async (req, res) => {
    console.log("Request Body:", req.body); // Log incoming payload
    try {
        const { title, description, status, dueDate, priority, userId } = req.body;

        if (!title || !userId) {
            return res.status(400).json({ error: "Title and UserId are required!" });
        }

        const task = new taskModel({ title, description, status, dueDate, priority, userId });
        const saveTask = await task.save();
        res.status(201).json(saveTask);
    } catch (error) {
        console.error("Error creating task:", error);
        res.status(500).json({ error: "Internal Server Error" });
    }
});


// updating task (PUT)
router.put("/task/:id", async (req, res) => {
    try {
        const updatedTask = await taskModel.findByIdAndUpdate(
            req.params.id,
            { ...req.body, updatedAt: Date.now()}, // Update fields and timestamp
            { new: true, runValidators: true} // Return the updated document
        );

        if(!updatedTask) {
            return res.status(400).json({Error: "task did not updated"});
        }
        res.status(200).json(updatedTask);
   } catch(Error) {
    res.status(400).json({message: "not updating task " + Error});
}
});


// deleting task (delete)
router.delete("/task/:id", async (req, res) => {
    try {
        const deleteTask = await taskModel.findByIdAndDelete(req.params.id);
        if(!deleteTask) {
            return res.status(400).json({Error: "task did not delete"});
        }
        res.status(200).json({ message: "Task deleted successfully" });
    } catch(Error) {
        res.status(400).json({message: "not deleting task " + Error});
    }
});

module.exports = router;