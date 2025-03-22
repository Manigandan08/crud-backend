import axios from "axios";
export const DeleteAll = async () => {
  const delete1 = await axios.delete("http://localhost:8080/tasks/v1");
  return delete1.data;
};

export const DeleteById = async (id) => {
  const delete1 = await axios.delete(`http://localhost:8080/tasks/v1/${id}`);
  return delete1.data;
};
