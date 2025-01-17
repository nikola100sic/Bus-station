import React, { useEffect, useState } from "react";
import carrierServiceAxios from "../../components/api/carrier.service.axios";
import { CarrierCard, CarrierPageStyled } from "./CarrierPage.styled";

const CarrierPage = () => {
  const [carriers, setCarriers] = useState([]);

  const getCarriers = async () => {
    try {
      const res = await carrierServiceAxios.getCarriers();
      setCarriers(res.data);
      console.log(res.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getCarriers();
  }, []);
  return (
    <CarrierPageStyled>
      {carriers.map((carrier) => (
        <CarrierCard>
          <p>Carrier's name: {carrier.name}</p>
          <p>Address: {carrier.address}</p>
          <p>E mail: {carrier.email}</p>
          <p>Phone number: {carrier.phoneNumber}</p>
        </CarrierCard>
      ))}
    </CarrierPageStyled>
  );
};

export default CarrierPage;
