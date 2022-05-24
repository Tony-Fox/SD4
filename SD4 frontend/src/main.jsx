import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App';
import AddRestaurant from './routes/addRestaurant';
import Restaurants from './routes/restaurants';
import Invoice from './routes/invoice';
import './main.css';
import TestPage from "./routes/testPage";
import Products from "./routes/products";
import AddProduct from "./routes/addProduct";

const rootElement = document.getElementById('app');

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="restaurant/add" element={<AddRestaurant />} />
        <Route path="restaurants" element={<Restaurants />}>
          <Route
            index
            element={
              <main style={{ padding: '1rem' }}>
                <p>Select a restaurant.</p>
              </main>
            }
          />
          <Route path=":restaurantId" element={<Products />} />
            <Route
                index
                element={
                    <main style={{ padding: '1rem' }}>
                        <p>Select a restaurant.</p>
                    </main>
                }
            />
            <Route path=":restaurantId/add" element={<AddProduct />} />
        </Route>
        <Route
          path="*"
          element={
            <main style={{ padding: '1rem' }}>
              <p>There's nothing here!</p>
            </main>
          }
        />
      </Route>
    </Routes>
  </BrowserRouter>,
  rootElement
);
