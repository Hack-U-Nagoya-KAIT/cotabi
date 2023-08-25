import { LinearGradient } from 'expo-linear-gradient';
import * as Location from 'expo-location';
import React, { useState } from 'react';
import { Alert, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

const PromptScreen = ({ navigation }) => {
  const [budget, setBudget] = useState('');
  const [hours, setHours] = useState('');
  const [minutes, setMinutes] = useState('');
  const [concept, setConcept] = useState('');
  const [location, setLocation] = useState(null);

  const handleSearch = async () => {
    const timeRequired = parseInt(hours) * 60 + parseInt(minutes);

    try {
      let response = await fetch('https://68df-182-21-98-168.ngrok-free.app/api/location', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          time: timeRequired,
          budget: parseInt(budget),
          concept: concept,
          latitude: location?.coords.latitude,
          longitude: location?.coords.longitude,
        }),
      });

      let jsonResponse = await response.json();

      if (jsonResponse.success) {
        navigation.navigate('Search', {
          budget: budget,
          timeRequired: timeRequired,
          concept: concept,
          id: jsonResponse.id // jsonResponseの中からidフィールドの値を取得して渡す
        });
      } else {
        Alert.alert("エラー", "サーバーへのデータ送信に失敗しました。");
      }
    } catch (error) {
      console.error(error);
      Alert.alert("エラー", "サーバーとの通信中にエラーが発生しました。");
    }
  };

  const getGeolocation = async () => {
    let { status } = await Location.requestForegroundPermissionsAsync();
    if (status !== 'granted') {
      console.error('位置情報のアクセスが許可されていません');
      return;
    }

    let currentLocation = await Location.getCurrentPositionAsync({});
    setLocation(currentLocation);
  };

  // 位置情報の取得ボタンをクリックするたびに位置情報を更新
  React.useEffect(() => {
    getGeolocation();
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>旅の作成</Text>
      <TextInput
        style={styles.input}
        placeholder="予算額"
        value={budget}
        onChangeText={setBudget}
        keyboardType="numeric"
      />
      <Text style={styles.unit}>円</Text>
      
      <View style={styles.timeInputContainer}>
        <TextInput
          style={styles.timeInput}
          placeholder="時間"
          value={hours}
          onChangeText={setHours}
          keyboardType="numeric"
        />
        
        <Text>時間</Text>
        <TextInput
          style={styles.timeInput}
          placeholder="分"
          value={minutes}
          onChangeText={setMinutes}
          keyboardType="numeric"
        />
        <Text>分</Text>
      </View>
      <TextInput
        style={styles.input}
        placeholder="コンセプト"
        value={concept}
        onChangeText={setConcept}
      />
      <View style = {styles.c}>
      <TouchableOpacity
        style={[styles.primaryButtonLayout, styles.buttonShadow]}
        onPress={handleSearch}
      >
        <LinearGradient
          colors={['#022534', '#08546C', '#A0BACC']} 
          start={{x:0.0, y:0.5}}
          end={{x:1.0, y:0.5}}
          style={styles.primaryButton}
        >
          <Text style={styles.primaryButtonText}>検索する</Text>
        </LinearGradient>
      </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding:16
  },
  heading: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginBottom: 15,
  },
  unit: {
    marginBottom: 15,
  },
  timeInputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 15,
  },
  timeInput: {
    flex: 1,
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
  },
  customButton: {
    borderRadius: 34,
    overflow: 'hidden',
    marginBottom: 10,
  },
  createButton: {
    width: 350,
    height: 40,
    transform: [{ rotate: '0deg' }],
  },
  buttonText: {
    color: '#FFF',
    fontWeight: 'bold',
    textAlign: 'center',
  },
  
  primaryButtonLayout: {
    alignSelf:'stretch',
    // marginHorizontal:16,
    marginVertical:8,
    backgroundColor:"#E5DFD8",
    borderRadius:33,
  },
  primaryButton: {
    borderStyle:'solid',
    borderColor:'#FFFFFF',
    borderWidth:1,
    borderRadius:33,
  },
  primaryButtonText: {
    textAlign:'center',
    margin:16,
    color:'#FFFFFF',
    fontSize:16,
    fontWeight:'bold',
  },
  buttonShadow: {
    shadowColor:'#000',
    shadowOffset:{width:2, height:2},
    shadowOpacity:0.5,
    shadowRadius: 2,
  }

});

export default PromptScreen;
