import { BusStationAxios } from "./axios";

const getLines = (date, destination, departure, maxPrice, minPrice) => {
  return BusStationAxios.get("/lines", {
    params: { date, destination, departure, maxPrice, minPrice },
  });
};

const getLine = (id) => {
  return BusStationAxios.get(`/lines/${id}`);
};

const deleteLine = (id) => {
  return BusStationAxios.delete(`/lines/${id}`);
};

const updateLine = (line) => {
  return BusStationAxios.update(`/lines`, line);
};

const addLine = (newLine) => {
  return BusStationAxios.add(`/lines`, newLine);
};

export default {
  getLines,
  getLine,
  deleteLine,
  updateLine,
  addLine,
};
