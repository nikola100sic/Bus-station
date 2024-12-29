import React, { useEffect } from "react";
import { jwtDecode } from "jwt-decode";
import {
  StyledHeader,
  StyledLinks,
  StyledLinksWrapper,
  StyledLogoutWrapper,
  StyledRegistrationLoginWrapper,
} from "./Header.styled";
import { Link } from "react-router-dom";
import { FaUser, FaUserLarge, FaUserPlus } from "react-icons/fa6";

const Header = (brandName, navItems) => {
  const token = localStorage.getItem("jwt");

  const handleLogout = () => {
    localStorage.removeItem("jwt");
    window.location.replace("/home");
  };

  useEffect(() => {
    if (token) {
      try {
        const decoded = jwtDecode(token);
        const currentTime = Date.now() / 1000;
        if (decoded.exp < currentTime) {
          handleLogout();
        }
      } catch (error) {
        console.error("Invalid token", error);
        handleLogout();
      }
    }
  }, [token]);
  return (
    <StyledHeader>
      <StyledLinks to={"/home"}>
        <h3>{brandName}</h3>
      </StyledLinks>
      <StyledLinksWrapper>
        {navItems.map((item) => (
          <StyledLinks to={item.path} key={item.path}>
            {item.title}
          </StyledLinks>
        ))}
      </StyledLinksWrapper>
      <StyledRegistrationLoginWrapper>
        {token ? (
          //TODO ADD!
          <></>
        ) : (
          <>
            <StyledLinks to={"/login"}>
              <FaUser style={{ marginRight: "5px" }} /> Login
            </StyledLinks>
            <StyledLinks to={"/registration"}>
              <FaUserPlus style={{ marginRight: "5px" }} /> Registration
            </StyledLinks>
          </>
        )}
      </StyledRegistrationLoginWrapper>
    </StyledHeader>
  );
};

export default Header;
