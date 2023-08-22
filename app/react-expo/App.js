import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import React from 'react';
import { StyleSheet } from 'react-native';
import GeolocationScreen from './screens/Geolocation';
import HomeScreen from './screens/HomeScreen';
import UserScreen from './screens/UserScreen';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName='Home'>{/* アプリ起動最初の画面設定 */}
        <Stack.Screen
        name="Home"
        component={HomeScreen}
        options={{title: 'ホーム画面'}} />
        <Stack.Screen
        name="User"
        component={UserScreen}
        options={{title: 'ユーザ画面',headerShown: true}} />
        <Stack.Screen
        name="geo"
        component={GeolocationScreen}
        options={{title: '位置情報画面'}}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
  // const [data, setData] = useState('');

  // useEffect(() => {
  //   const fetchData = async () => {
  //     try {
  //       //axios.getの後かっこの中身を毎回変更する
  //       const response = await axios.get('https://8a1f-2400-4051-cfe0-6600-3568-209e-6b99-456a.ngrok-free.app/api/data');
  //       setData(response.data);
  //     } catch (error) {
  //       console.error(error);
  //     }
  //   };

  //   fetchData();
  // }, []);

  // return (
  //   <View style={styles.container}>
  //     <Text>Data from Spring Boot: {data}</Text>
  //     <StatusBar style="auto" />
  //   </View>
  // );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
