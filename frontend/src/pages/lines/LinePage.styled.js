import styled from "styled-components";

export const LinePageStyled = styled.div`
  position: relative;
  width: 100%;
  /* min-height: calc(100vh - 120px); */
  display: flex;
  justify-content: center;
  align-items: center;
  /* padding: 20px; */
  overflow: hidden;

  &::before {
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

export const SearchParamsStyled = styled.div`
  background-color: rgb(92 125 131 / 34%);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(1px);
  -webkit-backdrop-filter: blur(5px);
  display: flex;
  flex-direction: column;
  width: 60%;
`;

export const InputRow = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  gap: 40px;
`;

export const InputGroup = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
`;

export const SearchInput = styled.input`
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;

  ::placeholder {
    color: #888;
    font-style: italic;
  }
`;

export const FormLabel = styled.label`
  margin-bottom: 5px;
  color: rgb(0, 0, 0);
  font-size: large;
`;
