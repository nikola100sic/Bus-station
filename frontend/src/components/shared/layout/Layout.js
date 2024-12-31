import React from "react";
import { Content, StyledPageContainer } from "./Layout.styled";
import Header from "../header/Header";
import Footer from "../footer/Footer";

const NAVITEMS = [
  {
    title: "Home",
    path: "/home",
    requiresAuth: false,
  },
  {
    title: "Lines",
    path: "/lines",
    requiresAuth: false,
  },
  {
    title: "Carriers",
    path: "/carriers",
    requiresAuth: false,
  },
];
const Layout = ({ children }) => {
  const token = localStorage.getItem("jwt");
  const filteredNavItems = NAVITEMS.filter((item) =>
    item.requiresAuth ? token : true
  );

  return (
    <StyledPageContainer>
      <Header brandName="Bus station" navItems={filteredNavItems}></Header>
      <Content>{children}</Content>
      <Footer text="© 2025 Bus station app. All rights reserved. | Made by Nikola"></Footer>
    </StyledPageContainer>
  );
};

export default Layout;
