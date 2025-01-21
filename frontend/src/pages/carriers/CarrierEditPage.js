import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import carrierServiceAxios from "../../components/api/carrier.service.axios";
import {
  CarrierFormContainer,
  CarrierFormInput,
  CarrierFormTitle,
  FormLabel,
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
      <FormLabel>Name:</FormLabel>
      <CarrierFormInput
        type="text"
        placeholder="Enter carrier's name"
        name="name"
        value={carrier.name}
      />
      <FormLabel>Address:</FormLabel>
      <CarrierFormInput
        type="text"
        placeholder="Enter address"
        name="address"
        value={carrier.address}
      />
      <FormLabel>Phone number:</FormLabel>
      <CarrierFormInput
        type="text"
        placeholder="Enter phone number"
        name="phonenumber"
        value={carrier.phoneNumber}
      />
      <FormLabel>E mail:</FormLabel>
      <CarrierFormInput
        type="text"
        placeholder="Enter carrier's e Mail"
        name="email"
        value={carrier.email}
      />
    </CarrierFormContainer>
  );
};

export default CarrierEditPage;
