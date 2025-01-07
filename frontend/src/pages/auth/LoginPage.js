import React, { use, useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  AuthFormContainer,
  AuthFormInput,
  AuthFormTitle,
  ButtonContainer,
  FormLabel,
} from "../../components/shared/forms/Forms.styled";
import Button from "../../components/shared/button/Button";
import { toast } from "react-toastify";
import AuthUtil from "../../utils/authUtil";

const LoginPage = () => {
  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (user.username === "" || user.password === "") {
      toast.warn("Please fill in all fields.");
      return;
    }
    try {
      const resp = await AuthUtil.post("/login", user);
      window.localStorage.setItem("jwt", resp.data);
      window.location.replace("/home");
      toast.success("Login successful!");
    } catch (error) {
      console.log(error);
      toast.warn(error.response.data);
    }
  };

  return (
    <AuthFormContainer>
      <AuthFormTitle>Login</AuthFormTitle>
      <FormLabel>Username: </FormLabel>
      <AuthFormInput
        type="text"
        placeholder="Enter your username"
        name="username"
        onChange={handleChange}
        value={user.username}
      />
      <FormLabel>Password: </FormLabel>
      <AuthFormInput
        type="password"
        placeholder="Enter your password"
        name="password"
        onChange={handleChange}
        value={user.password}
      />
      <ButtonContainer>
        <Button text="Login" type="submit" />
        <Button
          text="Create acount"
          type="submit"
          onClick={() => navigate("/registration")}
        />
      </ButtonContainer>
    </AuthFormContainer>
  );
};

export default LoginPage;
