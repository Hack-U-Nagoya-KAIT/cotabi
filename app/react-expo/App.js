import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import React from 'react';
import { StyleSheet } from 'react-native';
import CurrentScreen from './screens/CurrentScreen';
import HistoryScreen from './screens/HistoryScreen';
import GeolocationScreen from './screens/Geolocation';
import HomeScreen from './screens/HomeScreen';
import PromptScreen from './screens/PromptScreen';
import SearchScreen from './screens/SearchScreen';
import SettingScreen from './screens/SettingScreen';
import UserScreen from './screens/UserScreen';
const Stack = createNativeStackNavigator();

export default function App() {//画面遷移管理
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
        name="Prompt"
        component={PromptScreen} // PromptScreen コンポーネントを指定
        options={{ title: 'プロンプト入力画面', headerShown: true }}/>
        <Stack.Screen
        name="Search"
        component={SearchScreen} // SearchScreen コンポーネントを指定
        options={{ title: '検索画面', headerShown: true }}/>
        <Stack.Screen
        name="Current"
        component={CurrentScreen}
        options={{title: '現在のプラン画面',headerShown: true}} />
        <Stack.Screen
        name="History"
        component={HistoryScreen}
        options={{ title: '履歴画面', headerShown: true }} />
        <Stack.Screen
        name="Setting"
        component={SettingScreen}
        options={{ title: '設定画面', headerShown: true }} />
        name="Geo"
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
