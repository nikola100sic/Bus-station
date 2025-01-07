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
