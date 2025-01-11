import { Route, Routes } from "react-router-dom";
import Layout from "./components/shared/layout/Layout";
import Home from "./pages/home/Home";
import LoginPage from "./pages/auth/LoginPage";
import { ToastContainer } from "react-toastify";
import RegistrationPage from "./pages/auth/RegistrationPage";
import LinePage from "./pages/lines/LinePage";

function App() {
  return (
    <>
      <Layout>
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/lines" element={<LinePage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/registration" element={<RegistrationPage />} />
        </Routes>
      </Layout>
      <ToastContainer
        position="top-center"
        autoClose={2500}
        hideProgressBar
        rtl={false}
        pauseOnFocusLoss
        theme="dark"
        style={{
          position: "-moz-initial",
          top: "9%",
          zIndex: 9999,
        }}
      />
    </>
  );
}

export default App;
