import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App';
import AddDevice from './routes/addDevice';
import Devices from './routes/devices';
import Invoice from './routes/invoice';
import './main.css';
import TestPage from "./routes/testPage";
import Sensors from "./routes/sensors";
import AddSensor from "./routes/addSensor";
import SensorReadings from "./routes/sensorReadings";

const rootElement = document.getElementById('app');

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="device/add" element={<AddDevice />} />
        <Route path="devices" element={<Devices />}>
          <Route
            index
            element={
              <main style={{ padding: '1rem' }}>
                <p>Select a device.</p>
              </main>
            }
          />
          <Route path=":deviceId" element={<Sensors />}>
            <Route path=":sensorId" element={<SensorReadings />} />
            </Route>

            <Route
                index
                element={
                    <main style={{ padding: '1rem' }}>
                        <p>Select a device.</p>
                    </main>
                }
            />
            <Route path=":deviceId/add" element={<AddSensor />} />
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
