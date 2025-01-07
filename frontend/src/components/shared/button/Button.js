import React from "react";
import { StyledButton, SubmitButton } from "./Button.styled";

const Button = ({
  text,
  onClick,
  variant,
  type,
  color,
  textColor,
  disabled,
}) => {
  return (
    <>
      {type === "submit" ? (
        <SubmitButton
          $variant={variant}
          $color={color}
          $textcolor={textColor}
          disabled={disabled}
          type={type}
          onClick={onClick}
        >
          {text}
        </SubmitButton>
      ) : (
        <StyledButton
          $variant={variant}
          $color={color}
          $textcolor={textColor}
          disabled={disabled}
          type={type}
          onClick={onClick}
        >
          {text}
        </StyledButton>
      )}
    </>
  );
};

export default Button;
