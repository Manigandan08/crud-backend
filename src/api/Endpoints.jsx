import axios from "axios";

export const getData = async () => {
  const List = await axios.get("http://localhost:8080/tasks/v1");
  return List;
};

export const addData = async (task) => {
  await axios.post("http://localhost:8080/tasks/v1/add", task, {
    headers: { "Content-Type": "application/json" },
  });
};
