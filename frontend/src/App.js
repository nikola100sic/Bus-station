import { Route, Routes } from "react-router-dom";
import Layout from "./components/shared/layout/Layout";
import Home from "./pages/home/Home";

function App() {
  return (
    <>
      <Layout>
        <Routes>
          <Route path="/home" element={<Home />} />
        </Routes>
      </Layout>
    </>
  );
}

export default App;
