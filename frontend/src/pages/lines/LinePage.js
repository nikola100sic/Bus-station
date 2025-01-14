import React, { useEffect, useState } from "react";
import lineServiceAxios from "../../components/api/line.service.axios";
import {
  FormLabel,
  InputGroup,
  InputRow,
  LinePageStyled,
  SearchInput,
  SearchParamsStyled,
} from "./LinePage.styled";
import Button from "../../components/shared/button/Button";
import { ButtonContainer } from "../../components/shared/forms/Forms.styled";

const LinePage = () => {
  const [lines, setLines] = useState(null);

  const getLines = async (destination, carrierId, maxPrice) => {
    try {
      const res = await lineServiceAxios.getLines(
        destination,
        carrierId,
        maxPrice
      );
      setLines(res.data);
      console.log(res.data);
    } catch (error) {
      console.error("Error", error);
    }
  };

  useEffect(() => {
    getLines();
  }, []);

  return (
    <LinePageStyled>
      <SearchParamsStyled>
        <InputRow>
          <InputGroup>
            <FormLabel>Date:</FormLabel>
            <SearchInput placeholder="Select date" type="datetime-local" />
          </InputGroup>
          <InputGroup>
            <FormLabel>Destination:</FormLabel>
            <SearchInput placeholder="Enter destination" />
          </InputGroup>
          <InputGroup>
            <FormLabel>Departure:</FormLabel>
            <SearchInput placeholder="Enter departure" />
          </InputGroup>
        </InputRow>
        <InputRow>
          <InputGroup>
            <FormLabel>Minimum price:</FormLabel>
            <SearchInput placeholder="Enter min price" />
          </InputGroup>
          <InputGroup>
            <FormLabel>Maximum price:</FormLabel>
            <SearchInput placeholder="Enter max price" />
          </InputGroup>
        </InputRow>
        <ButtonContainer>
          <Button text="Search" color="#f1c40f8a"></Button>
        </ButtonContainer>
      </SearchParamsStyled>
    </LinePageStyled>
  );
};

export default LinePage;
