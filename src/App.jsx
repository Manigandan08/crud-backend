import { useState, useEffect } from "react";
import "./App.css";
import {
  Button,
  List,
  ListItem,
  Stack,
  TableRow,
  TextField,
  Typography,
} from "@mui/material";
import { addData, getData } from "./api/Endpoints";
import { DeleteAll, DeleteById } from "./api/Delete";

function App() {
  const [Todos, setTodos] = useState([]);

  const [oneTodo, setoneTodo] = useState({
    task: "",
    isComplete: false,
    isEditing: false,
  });

  useEffect(() => {
    getTodos();
  }, []);

  const getTodos = async () => {
    const List = await getData();
    setTodos(List.data);
  };

  const AddTodos = async () => {
    if (oneTodo.task.trim() !== "") {
      await addData(oneTodo);
      getTodos();
      setoneTodo({
        task: "",
        isComplete: false,
        isEditing: false,
      });
    }
  };

  const HandleChange = (e) => {
    const { name, value } = e.target;
    setoneTodo({ ...oneTodo, [name]: value });
  };

  const HandleDeleteById = async (id) => {
    await DeleteById(id);
    getTodos();
  };

  const HandleDeleteAll = async () => {
    const val = await DeleteAll();
    setTodos(val);
  };
  console.log(Todos);
  return (
    <div>
      <Stack direction="row" spacing="10px">
        <TextField
          variant="outlined"
          name="task"
          size="medium"
          onChange={HandleChange}
          value={oneTodo.task}
        />
        <Button variant="contained" size="small" onClick={AddTodos}>
          Add
        </Button>
        <Button variant="outlined" onClick={HandleDeleteAll}>
          Delete All
        </Button>
      </Stack>

      <List>
        {Todos.map((todo) => (
          <ListItem key={todo.id}>
            <Stack direction="row">
              <Typography style={{ marginLeft: "10px" }}>{todo.id}</Typography>
              <Typography style={{ marginLeft: "10px" }}>
                {todo.task}
              </Typography>
              <Button
                variant="contained"
                size="small"
                style={{ marginLeft: "10px" }}
              >
                Edit
              </Button>
              <Button
                variant="outlined"
                style={{ marginLeft: "10px" }}
                onClick={() => HandleDeleteById(todo.id)}
              >
                Delete
              </Button>
            </Stack>
          </ListItem>
        ))}
      </List>
    </div>
  );
}

export default App;
