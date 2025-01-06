import axios from "axios";

export const BusStationAxios = axios.create({
  baseURL: process.env.REACT_APP_API_URL,
  headers: {
    Accept: "application/json",
  },
});

export const AuthAxios = axios.create({
  baseURL: process.env.REACT_APP_AUTH_URL,
  headers: {
    Accept: "application/json",
  },
});

BusStationAxios.interceptors.request.use(function add_jwt(config) {
  if (window.localStorage["jwt"]) {
    config.headers["Authorization"] = "Bearer " + window.localStorage["jwt"];
  }

  return config;
});
