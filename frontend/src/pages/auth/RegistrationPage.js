import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  AuthFormContainer,
  AuthFormInput,
  AuthFormTitle,
  ButtonContainer,
  CheckboxInput,
  FormLabel,
  Label,
} from "../../components/shared/forms/Forms.styled";
import Button from "../../components/shared/button/Button";
import { toast } from "react-toastify";
import { AuthAxios } from "../../components/api/axios";

const RegistrationPage = () => {
  const [user, setUser] = useState({
    name: "",
    surname: "",
    username: "",
    password: "",
    repeatedPassword: "",
    email: "",
  });

  const [termsAccepted, setTermsAccepted] = useState(false);
  const [privacyPolicyAccepted, setPrivacyPolicyAccepted] = useState(false);
  const navigate = useNavigate();

  const isFormValid = termsAccepted && privacyPolicyAccepted;

  const handleChange = (event) => {
    const { name, value } = event.target;
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (
      !user.name ||
      !user.surname ||
      !user.username ||
      !user.email ||
      !user.password ||
      !user.repeatedPassword
    ) {
      toast.warn("Please fill in all fields.");
      return;
    }
    if (!isFormValid) {
      toast.warn(
        "You must agree to the terms and conditions and the privacy policy before registration."
      );
      return;
    }
    try {
      await AuthAxios.post("/registration", user);
      navigate("/login");
      toast.success(
        "Registration successful! Please verify your email before logging in."
      );
    } catch (error) {
      toast.error(error.response.data || "Error");
      console.log(user);
    }
  };

  return (
    <AuthFormContainer>
      <AuthFormTitle>Registration</AuthFormTitle>
      <FormLabel>Name: </FormLabel>
      <form onSubmit={handleSubmit}>
        <AuthFormInput
          type="text"
          value={user.name}
          onChange={handleChange}
          name="name"
          placeholder="Enter your name"
        />
        <FormLabel>Surname: </FormLabel>
        <AuthFormInput
          type="text"
          value={user.surname}
          onChange={handleChange}
          name="surname"
          placeholder="Enter your surname"
        />
        <FormLabel>Username: </FormLabel>
        <AuthFormInput
          type="text"
          value={user.username}
          onChange={handleChange}
          name="username"
          placeholder="Enter your username"
        />
        <FormLabel>E mail: </FormLabel>
        <AuthFormInput
          type="text"
          value={user.email}
          onChange={handleChange}
          name="email"
          placeholder="Enter your e mail"
        />
        <FormLabel>Password: </FormLabel>
        <AuthFormInput
          type="password"
          value={user.password}
          onChange={handleChange}
          name="password"
          placeholder="Enter your password"
        />
        <FormLabel>Repeat password: </FormLabel>
        <AuthFormInput
          type="password"
          value={user.repeatedPassword}
          onChange={handleChange}
          name="repeatedPassword"
          placeholder="Enter repeat password"
        />
        <>
          <Label>
            <CheckboxInput
              type="checkbox"
              checked={termsAccepted}
              onChange={() => setTermsAccepted(!termsAccepted)}
            />
            I agree to the terms and conditions
          </Label>
        </>
        <>
          <Label>
            <CheckboxInput
              type="checkbox"
              checked={privacyPolicyAccepted}
              onChange={() => setPrivacyPolicyAccepted(!privacyPolicyAccepted)}
            />
            I agree to the privacy policy
          </Label>
        </>
        <ButtonContainer>
          <Button text="Create account" type="submit" />
          <Button
            text="I already have an account"
            type="submit"
            onClick={() => navigate("/login")}
          />
        </ButtonContainer>
      </form>
    </AuthFormContainer>
  );
};

export default RegistrationPage;
