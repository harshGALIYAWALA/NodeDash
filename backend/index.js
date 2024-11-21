const mongoose = require("mongoose");
const express = require("express");
const routes = require("./routes/curdOp");

const app = express();
app.use(express.json());

// connecting to mongodb
mongoose.connect("mongodb://127.0.0.1:27017/ToDoTask", 
    {
        useNewUrlParser: true,
        useUnifiedTopology: true
    }
).then(() => console.log("mongo is connected!"))
.catch(Error => console.log("momgo is not working " , Error))


app.use("/api", routes);

app.listen(5000, () => {
    console.log("server started");
});