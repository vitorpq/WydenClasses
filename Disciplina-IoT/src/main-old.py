# Complete project details at https://RandomNerdTutorials.com

from machine import Pin, I2C
from time import sleep
import BME280

# ESP32 - Pin assignment
#i2c = I2C(scl=Pin(22), sda=Pin(21), freq=10000)
# ESP8266 - Pin assignment
i2c = I2C(scl=Pin(5), sda=Pin(4), freq=10000)

while True:
  bme = BME280.BME280(i2c=i2c)
  temp = bme.temperature
  hum = bme.humidity
  pres = bme.pressure
  # uncomment for temperature in Fahrenheit
  #temp = (bme.read_temperature()/100) * (9/5) + 32
  #temp = str(round(temp, 2)) + 'F'
  alt = 44330 * (1 - ((bme.read_pressure/25600) / 1013.25)**0.1903)  # altitude em metros
  
  print('Temperature: ', temp)
  print('Humidity: ', hum)
  print('Pressure: ', pres)
  print('Altitude: ', alt)
  

  sleep(5)
