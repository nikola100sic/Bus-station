import { useEffect, useState } from "react";

const AuthUtil = () => {
  const [isAdmin, setIsAdmin] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem("jwt");
    if (token) {
      try {
        const payload = JSON.parse(atob(token.split(".")[1]));
        setIsLoggedIn(true);
        setIsAdmin(payload.role === "ADMIN");
        setUsername(payload.sub);
      } catch (error) {
        console.error("Error decoding token:", error);
        setIsLoggedIn(false);
        setIsAdmin(false);
        setUsername(null);
      }
    } else {
      setIsLoggedIn(false);
      setIsAdmin(false);
      setUsername(null);
    }
  }, []);
  return { isAdmin, isLoggedIn, username };
};

export default AuthUtil;
