import { BusStationAxios } from "./axios";

const getLines = (destination, carrierId, maxPrice) => {
  return BusStationAxios.get("/lines", {
    params: { destination, carrierId, maxPrice },
  });
};

const getLine = (id) => {
  return BusStationAxios.get(`/lines/${id}`);
};

export default {
  getLines,
  getLine,
};
