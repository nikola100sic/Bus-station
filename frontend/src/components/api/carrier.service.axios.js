import { BusStationAxios } from "./axios";

const getCarrier = (id) => {
  return BusStationAxios.get(`/carriers/${id}`);
};

export default {
  getCarrier,
};
