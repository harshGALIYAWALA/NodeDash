const mongoose = require("mongoose");

const taskSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true, // Task title is mandatory
        trim: true,
    },
    description: {
        type: String,
        required: false, // Optional for more details
        trim: true,
    },
    status: {
        type: String,
        enum: ['pending', 'in-progress', 'completed'], // Defines allowed statuses
        default: 'pending',
    },
    dueDate: {
        type: Date, // Date by which the task should be completed
        required: false,
    },
    priority: {
        type: String,
        enum: ['low', 'medium', 'high'], // Task priority levels
        default: 'low',
    },
    createdAt: {
        type: Date,
        default: Date.now, // Automatically set the creation date
    },
    updatedAt: {
        type: Date, // Updates whenever the task is modified
    },
    userId: {
        type: mongoose.Schema.Types.ObjectId, // References the user who created the task
        ref: 'User',
        required: true,
    },
});

module.exports = mongoose.model("taskModel", taskSchema);