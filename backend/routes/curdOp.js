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

    try{
        
        const {title, description, status, dueDate, priority, userId} = req.body;
        const task = new taskModel({title, description, status, dueDate, priority, userId});
        const saveTask = await task.save();
        
        res.status(201).json(saveTask);
    } catch(Error) {
        res.status(400).json({message: "not creating task " + Error});
    }
});


// updating task (PUT)
router.put("/task/:id", async (req, res) => {
    try {
        const updatedTask = await taskModel.findByIdAndUpdate(
            req.params.id,
            { ...req.body, updatedAt: Date.now()}, // Update fields and timestamp
            { new: true, runValidators: true} // Return the updated document
        )
   } catch {

   }
});