import styled from "styled-components";

export const AuthFormContainer = styled.div`
  flex-direction: column;
  display: flex;
  flex-direction: column;
  background: #3498db80;
  width: 400px;
  margin: 0 auto;
  padding: 30px;
  border-radius: 2px;
  box-shadow: -7px 13px 8px 0px rgba(0, 0, 0, 0.1);
`;

export const AuthFormTitle = styled.h3`
  text-align: center;
  color: #113775;
`;

export const AuthFormInput = styled.input`
  width: 90%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  ::placeholder {
    color: #888;
    font-style: italic;
  }
`;

export const FormLabel = styled.label`
  display: block;
  margin: 10px 0 5px;
  color: #ffffff;
  font-size: large;
`;

export const ButtonContainer = styled.div`
  display: flex;
  gap: 58px;
  justify-content: center;
  margin-top: 20px;
`;

export const CheckboxInput = styled.input`
  margin-right: 10px;
  cursor: pointer;
  transform: scale(1.4);
`;

export const Label = styled.span`
  font-size: 15px;
  font-weight: bold;
`;

export const CarrierFormContainer = styled(AuthFormContainer)`
  background: rgb(255 242 27 / 26%);
`;

export const CarrierFormTitle = styled(AuthFormTitle)`
  text-align: center;
  color: rgb(255, 255, 255);
`;

export const CarrierFormInput = styled(AuthFormInput)``;
