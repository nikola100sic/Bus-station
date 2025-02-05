import { NavLink } from "react-router-dom";
import styled from "styled-components";

export const StyledHeader = styled.header`
  display: flex;
  background: #e48306a3;
  color: black;
  box-shadow: 0px 10px 24px 0px rgba(0, 0, 0, 0.25);
  opacity: 0.85;
  padding: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  z-index: 10;
`;

export const StyledLinks = styled(NavLink)`
  text-decoration: none;
  color: black;
`;

export const StyledLinksWrapper = styled.div`
  display: flex;
  gap: 100px;
  flex-wrap: wrap;
`;

export const StyledRegistrationLoginWrapper = styled.div`
  display: flex;
  gap: 13px;
  flex-direction: column;
`;

export const StyledLogoutWrapper = styled.div`
  display: flex;
  align-items: "center";
  gap: 5px;
`;
