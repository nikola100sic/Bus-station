import { BusStationAxios } from "./axios";

const getCarrier = (id) => {
  return BusStationAxios.get(`/carriers/${id}`);
};

const getCarriers = () => {
  return BusStationAxios.get(`/carriers`);
};

const addCarier = (newCarrier) => {
  return BusStationAxios.add(`/carriers`, newCarrier);
};

const deleteCarrier = (id) => {
  return BusStationAxios.delete(`/carriers/${id}`);
};

export default {
  getCarrier,
  getCarriers,
  addCarier,
  deleteCarrier,
};
