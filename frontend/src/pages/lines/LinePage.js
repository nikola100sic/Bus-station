import React, { useEffect, useState } from "react";
import lineServiceAxios from "../../components/api/line.service.axios";

const LinePage = () => {
  const [lines, setLines] = useState(null);

  const getLines = async (destination, carrierId, maxPrice) => {
    try {
      const res = await lineServiceAxios.getLines(
        destination,
        carrierId,
        maxPrice
      );
      setLines(res.data);
      console.log(res.data);
    } catch (error) {
      console.error("Error", error);
    }
  };

  useEffect(() => {
    getLines();
  }, []);

  return (
    <div>
      <p>Lines</p>
    </div>
  );
};

export default LinePage;
