import React from "react";
import { GalleryContainer, HomePageStyle } from "./HomePage.styled";
import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  const handleGalleryClick = () => {
    navigate("/gallery");
  };

  return (
    <HomePageStyle>
      <GalleryContainer
        onClick={handleGalleryClick}
        style={{ cursor: "pointer" }}
      >
        Gallery
      </GalleryContainer>
    </HomePageStyle>
  );
};

export default Home;
