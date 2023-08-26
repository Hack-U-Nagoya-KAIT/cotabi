import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { ScrollView, StyleSheet, Text, View } from 'react-native';

const CurrentScreen = ({route}) => {
  const {id,styles} = route.params;
  const [companionData, setData_comp] = useState({});
  const [spotData, setData] = useState([]);
  const [routeData, setData_route] = useState([]);

  const [currentTime, setCurrentTime] = useState('');
  const [arrivalTime, setArrivalTime] = useState('');

  let API_URL_COMP = "https://3a8d-150-249-244-121.ngrok-free.app/api/db/read/comp/" + id;
  
  let API_URL_SPOT = "https://3a8d-150-249-244-121.ngrok-free.app/api/db/read/spot/" + id;

  let API_URL_ROUTE = "https://3a8d-150-249-244-121.ngrok-free.app/api/db/read/routes/" + id;

  useEffect(() => {
    const fetchData = async () => {
      try {

        const response = await axios.get(API_URL_COMP);
        setData_comp(response.data);  // 'response.data' を追加し、正しいプロパティを参照

        const response_spot = await axios.get(API_URL_SPOT);
        setData(response_spot.data);  // 'response.data' を追加。spotDataがAPIのルートにある場合はこれで良いですが、プロパティ名を変更する必要があるかもしれません。

        const response_route = await axios.get(API_URL_ROUTE);
        setData_route(response_route.data);

      } catch (error) {
        console.error("Error fetching the data:", error);
      }
    }

    fetchData();
  }, []);

  useEffect(() => {

    const getCurrentTime = () => {
      const now = new Date();
      const hours = now.getHours().toString().padStart(2, '0');
      const minutes = now.getMinutes().toString().padStart(2, '0');
      return `${hours}:${minutes}`;
    };

    const calculateArrivalTime = (duration) => {
      const now = new Date();
      const newTime = new Date(now.getTime() + duration * 60 * 1000); // 49分をミリ秒に変換
      const hours = newTime.getHours().toString().padStart(2, '0');
      const minutes = newTime.getMinutes().toString().padStart(2, '0');
      return `${hours}:${minutes}`;
    }
    
    setCurrentTime(getCurrentTime());
    // コンポーネントがレンダリングされるたびに ArrivalTime を計算してセット
    const calculatedArrivalTime = calculateArrivalTime(routeData.duration);
    setArrivalTime(calculatedArrivalTime);

    if (routeData.length > 0) {
      const calculatedArrivalTime = calculateArrivalTime(routeData[0].duration);
      setArrivalTime(calculatedArrivalTime);
    }
  }, [routeData]);

  
  return (
    <View style = {styles.container}>
      <View style = {[{flex:1}, {alignSelf:'stretch'}]}>
      <Text style = {styles.title}>現在のプラン画面</Text>
        <ScrollView style = {styles.outputScrollView} showsVerticalScrollIndicator = {true}>
        <Text style={styles.title}>cotabi</Text>
          
          {spotData && spotData.map((spot, index) => (
            <View key={index}>
              {/* <Text style={styles.title}>Spot ID: {spot.spotId}</Text> */}
              <Text style={styles.goal}>{spot.spotName}</Text>
              <Text style={styles.address}>{spot.spotAddress}</Text>

            </View>
          ))}

          {routeData && routeData.map((route, index) => (
            <View key={index}>
              <Text style={styles.movetool}>{currentTime}：現在地</Text>
              <Text style={styles.movetoolmin}>移動手段：車</Text>
              <Text style={styles.movetoolmin}>移動時間：{route.duration}分</Text>
              <Text style={styles.movetoolmin}>交通費：0円</Text>
            </View>
          ))}

          {spotData && spotData.map((spot, index) => (
            <View key={index}>
              <Text style={styles.movetool}>{arrivalTime}：{spot.spotName}</Text>
            </View>
          ))}
        </ScrollView>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex:1,
    alignItems:'center',
    justifyContent:'center',
    backgroundColor:'#E5DFD8',
  },
  title: {
    marginTop:16,
    marginBottom:0,
    textAlign:'center',
    fontSize:16,
  },
  outputScrollView: {
    margin:16,
    alignSelf:'stretch',
    textAlign:"left",
    backgroundColor:'#EFE8E5',
    borderColor:'#000000',
    borderWidth:2,
    borderRadius:16,
    padding:8,
  },
  outputText: {
    fontSize:16,
  }
});

export default CurrentScreen;
