import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  body::before {
    content: "";
    position: fixed;
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
