import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import carrierServiceAxios from "../../components/api/carrier.service.axios";
import {
  CarrierFormContainer,
  CarrierFormTitle,
} from "../../components/shared/forms/Forms.styled";

const CarrierEditPage = () => {
  const routeParams = useParams();
  const carrierId = routeParams.id;

  const [carrier, setCarrier] = useState({
    id: 0,
    email: "",
    address: "",
    name: "",
    phoneNumber: "",
  });
  const getCarrier = () => {
    carrierServiceAxios
      .getCarrier(carrierId)
      .then((res) => {
        setCarrier(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getCarrier();
  }, []);

  return (
    <CarrierFormContainer>
      <CarrierFormTitle>Edit page</CarrierFormTitle>
    </CarrierFormContainer>
  );
};

export default CarrierEditPage;
