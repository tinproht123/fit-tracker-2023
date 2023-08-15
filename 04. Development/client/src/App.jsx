import { CssBaseline, createTheme, Box } from "@mui/material";
import { ThemeProvider } from "@emotion/react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "./pages/Home";
import Navbar from "./components/Navbar";

function App() {
  const theme = createTheme({
    typography: {
      fontFamily: [
        "Saira Condensed",
        "Helvetica Neue",
        "Helvetica",
        "Arial",
        "sans-serif",
      ].join(","),
      fontSize: 16,
      color: "#ff0000",
      fontWeight: 400,
      h6: {
        fontWeight: 800,
      },
    },
  });

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <BrowserRouter>
        <Navbar />
        <Box
          sx={{
            w: "100%",
            maxWidth: "1440px",
            mx: "auto",
          }}
        >
          <Routes>
            <Route path="/" element={<HomePage />} />
          </Routes>
        </Box>
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;