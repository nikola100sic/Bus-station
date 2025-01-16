import styled from "styled-components";

export const LinePageStyled = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
`;

export const SearchParamsStyled = styled.div`
  display: flex;
  background-color: rgb(92 125 131 / 34%);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(1px);
  -webkit-backdrop-filter: blur(5px);
  flex-direction: column;
  margin-bottom: 40px;
`;

export const InputRow = styled.div`
  display: flex;
  justify-content: space-evenly;
  margin-bottom: 20px;
  gap: 40px;
  flex-wrap: wrap;
`;

export const InputGroup = styled.div`
  display: flex;
  flex-direction: column;
`;

export const SearchInput = styled.input`
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

export const DataViewContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
  width: 100%;
  flex-wrap: wrap;
`;

export const LineCard = styled.div`
  display: flex;
  background-color: #b3a02bb5;
  gap: 10px;
  color: snow;
  border-radius: 15px;
  padding: 15px;
`;
