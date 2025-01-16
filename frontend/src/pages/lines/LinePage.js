import React, { useEffect, useState } from "react";
import lineServiceAxios from "../../components/api/line.service.axios";
import {
  DataViewContainer,
  FormLabel,
  InputGroup,
  InputRow,
  LineCard,
  LinePageStyled,
  SearchInput,
  SearchParamsStyled,
} from "./LinePage.styled";
import Button from "../../components/shared/button/Button";
import { ButtonContainer } from "../../components/shared/forms/Forms.styled";

const LinePage = () => {
  const [lines, setLines] = useState(null);
  const [searchParams, setSearchParams] = useState({
    destination: "",
    departure: "",
    minPrice: "",
    maxPrice: "",
    date: "",
  });

  const getLines = async (date, destination, departure, maxPrice, minPrice) => {
    try {
      const res = await lineServiceAxios.getLines(
        date,
        destination,
        departure,
        maxPrice,
        minPrice
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

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setSearchParams((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSearch = () => {
    const { date, destination, departure, maxPrice, minPrice } = searchParams;
    getLines(date, destination, departure, maxPrice, minPrice);
    console.log(searchParams);
  };

  const formatDateTime = (dateTime) => {
    return dateTime ? dateTime.replace("T", " ") : "";
  };

  return (
    <LinePageStyled>
      <SearchParamsStyled>
        <InputRow>
          <InputGroup>
            <FormLabel>Date:</FormLabel>
            <SearchInput
              placeholder="Select date"
              type="datetime-local"
              name="date"
              value={searchParams.date}
              onChange={handleInputChange}
            />
          </InputGroup>
          <InputGroup>
            <FormLabel>Departure:</FormLabel>
            <SearchInput
              placeholder="Enter departure"
              name="departure"
              value={searchParams.departure}
              onChange={handleInputChange}
            />
          </InputGroup>
          <InputGroup>
            <FormLabel>Destination:</FormLabel>
            <SearchInput
              placeholder="Enter destination"
              name="destination"
              value={searchParams.destination}
              onChange={handleInputChange}
            />
          </InputGroup>
        </InputRow>
        <InputRow>
          <InputGroup>
            <FormLabel>Minimum price:</FormLabel>
            <SearchInput
              placeholder="Enter min price"
              name="minPrice"
              value={searchParams.minPrice}
              onChange={handleInputChange}
            />
          </InputGroup>
          <InputGroup>
            <FormLabel>Maximum price:</FormLabel>
            <SearchInput
              placeholder="Enter max price"
              name="maxPrice"
              value={searchParams.maxPrice}
              onChange={handleInputChange}
            />
          </InputGroup>
        </InputRow>
        <ButtonContainer>
          <Button
            text="Search"
            color="#f1c40f8a"
            onClick={handleSearch}
          ></Button>
        </ButtonContainer>
      </SearchParamsStyled>
      {lines && lines.length > 0 ? (
        <DataViewContainer>
          {lines.map((line) => (
            <LineCard key={line.id}>
              <p>Date and time: {formatDateTime(line.departureTime)},</p>
              <p> Departure: {line.departure},</p>
              <p> Destination: {line.destination},</p>
              <p> Price: {line.price}€ </p>
            </LineCard>
          ))}
        </DataViewContainer>
      ) : (
        <p></p>
      )}
    </LinePageStyled>
  );
};

export default LinePage;
