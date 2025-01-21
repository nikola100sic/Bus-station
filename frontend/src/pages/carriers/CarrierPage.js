import React, { useEffect, useState } from "react";
import carrierServiceAxios from "../../components/api/carrier.service.axios";
import { CarrierCard, CarrierPageStyled } from "./CarrierPage.styled";
import { ButtonContainer } from "../../components/shared/forms/Forms.styled";
import Button from "../../components/shared/button/Button";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import AuthUtil from "../../utils/authUtil";

const CarrierPage = () => {
  const [carriers, setCarriers] = useState([]);
  const navigate = useNavigate();
  const { isAdmin } = AuthUtil();

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

  const goToEdit = (carrierId) => {
    navigate(`/carriers/edit/${carrierId}`);
  };
  const handleDelete = (carrierId) => {
    toast(
      <>
        <>Are you sure you want to delete this carrier?</>
        <Button
          text="Yes"
          variant="filled"
          onClick={() => confirmDelete(carrierId)}
          color="#0052f779"
        />
        <Button
          text="No"
          variant="outlined"
          onClick={() => toast.dismiss()}
          color="rgba(247, 0, 0, 0.507)"
        />
      </>,
      {
        autoClose: false,
        closeButton: false,
      }
    );
  };

  const confirmDelete = (carrierId) => {
    toast.dismiss();

    carrierServiceAxios
      .deleteCarrier(carrierId)
      .then((res) => {
        console.log(res);
        toast.success("Successfully deleted");
        setCarriers((prevCarriers) =>
          prevCarriers.filter((carrier) => carrier.id !== carrierId)
        );
      })
      .catch((error) => {
        console.log(error);
        toast.error("Error");
      });
  };
  const deleteCarrier = (carrierId) => {
    handleDelete(carrierId);
  };
  return (
    <CarrierPageStyled>
      {carriers.map((carrier) => (
        <CarrierCard key={carrier.id}>
          <p>Carrier's name: {carrier.name}</p>
          <p>Address: {carrier.address}</p>
          <p>E-mail: {carrier.email}</p>
          <p>Phone number: {carrier.phoneNumber}</p>
          {isAdmin && (
            <ButtonContainer>
              <Button
                color="#26ff004f"
                text="Edit"
                onClick={() => goToEdit(carrier.id)}
              />
              <Button
                color="##ff000069"
                text="Delete"
                onClick={() => deleteCarrier(carrier.id)}
              />
            </ButtonContainer>
          )}
        </CarrierCard>
      ))}
    </CarrierPageStyled>
  );
};

export default CarrierPage;
