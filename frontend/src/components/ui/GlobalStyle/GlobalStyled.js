import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  body {
    font-family: 'Arial', sans-serif;
    background-color: #f5f5f5;
    overflow-x: hidden;
  }

  a {
    text-decoration: none;
    color: inherit;
  }

  body::before {
    content: "";
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url(/bus.jpg);
    background-size: cover;
    background-position: center;
    filter: blur(2px);
    z-index: -1;
  }
`;

export default GlobalStyle;
