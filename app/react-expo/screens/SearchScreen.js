import axios from 'axios';
import { LinearGradient } from 'expo-linear-gradient';
import React, { useState, useEffect } from 'react';
import { TouchableOpacity, Modal,Button, StyleSheet, Text, View, ScrollView } from 'react-native';
import MaskedView from '@react-native-masked-view/masked-view';

const API_URL_COMP = "https://cotabi.ngrok.app/api/db/read/comp/1";
const API_URL_SPOT = "https://cotabi.ngrok.app/api/db/read/spot/1";







const SearchScreen = ({ navigation, route }) => {
  const [companionData, setData_comp] = useState({});
  const [spotData, setData] = useState([]);
  
  const { budget, timeRequired, concept } = route.params;
  const [showAlert, setShowAlert] = useState(false);
  const [showAbortAlert, setShowAbortAlert] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(API_URL_COMP);  
        setData_comp(response.data);  // 'response.data' を追加し、正しいプロパティを参照

        const response_spot = await axios.get(API_URL_SPOT);  
        setData(response_spot.data);  // 'response.data' を追加。spotDataがAPIのルートにある場合はこれで良いですが、プロパティ名を変更する必要があるかもしれません。
      } catch (error) {
        console.error("Error fetching the data:", error);
      }
    }

    fetchData();
  }, []);




// const SearchScreen = ({ navigation, route }) => {
//   const { budget, timeRequired, concept } = route.params;
//   const [showAlert, setShowAlert] = useState(false);
//   const [showAbortAlert, setShowAbortAlert] = useState(false);



  const handleSavePlan = () => {
    // プランの保存処理
  };

  const handleChangeConditions = () => {
    // 条件変更処理
  };

  const handleRegenerate = () => {
    // 再生成処理
  };

  const handleShowAlert = () => {
    setShowAlert(true);
  };

  const handleShowAbortAlert = () => {
    setShowAbortAlert(true);
  };

  const handleCloseAlert = () => {
    setShowAlert(false);
    setShowAbortAlert(false);
  };

  const handleAction = (actionType) => {//いらない？かも
    if (actionType === 'regenerate') {
      // 再生成処理
    } else if (actionType === 'changeConditions') {
      // 条件変更処理
    }
    handleCloseAlert();
  };

  const handleAbort = () => {
    handleShowAbortAlert();
  };


  return (
    <View style={styles.container} >
      <View style = {[{flex:2}, {alignSelf:'stretch'}]}>
      <ScrollView style={styles.outputScrollView} showsVerticalScrollIndicator={true}>
      <Text style={styles.title}>cotabi</Text>
      <Text style={styles.goal}>鶴岡八幡宮</Text>
      <Text style={styles.address}>鎌倉市雪ノ下２丁目1番31号</Text>
      <Text style={styles.route}>経路</Text>

      <Text style={styles.movetool}>12:50：現在地</Text>
      <Text style={styles.movetoolmin}>移動手段：車</Text>
      <Text style={styles.movetoolmin}>移動時間：73分</Text>
      <Text style={styles.movetoolmin}>交通費：0円</Text>
      <Text style={styles.movetool}>14:03：鶴岡八幡宮</Text>
{/* 
  {spotData && spotData.map((spot, index) => (
    <View key={index}>
      <Text style={styles.outputText}>Spot ID: {spot.spotId}</Text>
      <Text style={styles.outputText}>Spot Name: {spot.spotName}</Text>
      <Text style={styles.outputText}>Spot Lon: {spot.spotLon}</Text>
      <Text style={styles.outputText}>Spot Lat: {spot.spotLat}</Text>
      {spot.spotUrl && <Text style={styles.outputText}>Spot URL: {spot.spotUrl}</Text>}
    </View>
  ))}

  
  {companionData && (
    <>
      <Text style={styles.outputText}>Companion ID: {companionData.companionId}</Text>
      <Text style={styles.outputText}>Companion Title: {companionData.companionTitle}</Text>
      <Text style={styles.outputText}>Design Num: {companionData.designNum}</Text>
      <Text style={styles.outputText}>Test Text</Text>
    </>
  )} */
  }
</ScrollView>

      </View>
      <View style = {[{flex:1}, {alignSelf:'stretch'}]}>  
        <TouchableOpacity title="しおりを保存" style = {[styles.primaryButtonLayout, styles.buttonShadow]}
                onPress={() => {
                  handleSavePlan(); // handleSavePlan関数を呼び出す
                  navigation.navigate('Current'); // 'Current' 画面に遷移
                }}>
          <LinearGradient colors={['#022534', '#08546C', '#A0BACC']} 
            start={{x:0.0, y:0.5}}
            end={{x:1.0, y:0.5}}
            style={styles.primaryButton}>
            <Text style = {styles.primaryButtonText}>しおりを保存</Text>
          </LinearGradient>
        </TouchableOpacity>
        <TouchableOpacity title="条件変更・再生成" style = {[styles.secondaryButtonLayout, styles.buttonShadow]} onPress={handleShowAlert}>
          <LinearGradient colors={['#022534', '#08546C', '#A0BACC']} 
            start={{x:0.0, y:0.5}}
            end={{x:1.0, y:0.5}}
            style={{borderRadius: 33}}>
            <View style = {styles.secondaryButton}>
              <GradientText style={styles.secondaryButtonText}>条件変更・再生成</GradientText>
            </View>
          </LinearGradient>
        </TouchableOpacity>
        <TouchableOpacity title="生成中断" style = {styles.tertiaryButtonLayout} onPress={handleAbort} >
          <GradientText style = {styles.tertiaryButtonText}> 生成中断 </GradientText>
        </TouchableOpacity>
        <Button title="戻る" onPress={() => navigation.goBack()} />

        
      </View>
      {/* 再生成・条件変更アラートダイアログ */}
      <Modal
        visible={showAlert}
        transparent={true}
        animationType="fade"
        onRequestClose={handleCloseAlert}
      >
        <View style={styles.alertContainer}>
          <View style={styles.alertBox}>
            <Text style={styles.alertText}>
              再生成・条件変更しますか？
            </Text>
            <View style={styles.alertButtonContainer}>
              <TouchableOpacity
                style={[styles.alertButton, styles.changeConditionsButton]}
                onPress={() => {
                  navigation.navigate('Prompt');
                }}
              >
                <Text style={styles.alertButtonText}>再生成・条件変更</Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[styles.alertButton, styles.cancelButton]}
                onPress={handleCloseAlert}
              >
                <Text style={styles.alertButtonText}>キャンセル</Text>
              </TouchableOpacity>
            </View>
          </View>
        </View>
      </Modal>

      {/* 生成中断アラートダイアログ */}
      <Modal
        visible={showAbortAlert}
        transparent={true}
        animationType="fade"
        onRequestClose={handleCloseAlert}
      >
        <View style={styles.alertContainer}>
          <View style={styles.alertBox}>
            <Text style={styles.alertText}>
              旅の作成を中断しますか？
            </Text>
            <View style={styles.alertButtonContainer}>
              <TouchableOpacity
                style={[styles.alertButton, styles.abortButton]}
                onPress={() => {
                  navigation.navigate('User');
                }}
              >
                <Text style={styles.alertButtonText}>中断</Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[styles.alertButton, styles.cancelButton]}
                onPress={handleCloseAlert}
              >
                <Text style={styles.alertButtonText}>キャンセル</Text>
              </TouchableOpacity>
            </View>
          </View>
        </View>
      </Modal>
    </View>
  );
};

const GradientText = props => {
  return (
    <MaskedView maskElement={<Text {...props} />}>
      <LinearGradient
        colors={['#022534', '#08546C', '#A0BACC']}
        start={{x:0, y:0}}
        end={{x:1, y:0}}>
          <Text {...props} style={[props.style, {opacity: 0}]} />
        </LinearGradient>
    </MaskedView>
  )
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#E5DFD8',
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
  },
  primaryButtonLayout: {
    alignSelf:'stretch',
    marginHorizontal:16,
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
  },
  secondaryButtonLayout: {
    alignSelf:'stretch',
    marginHorizontal:16,
    marginVertical:8,
    backgroundColor:"#E5DFD8",
    borderRadius:33,
  },
  secondaryButton: {
    margin:2,
    backgroundColor:"#ffffff",
    borderRadius:33,
  },
  secondaryButtonText: {
    textAlign:"center",
    margin:16,
    fontSize:16,
    fontWeight:'bold'
  },
  tertiaryButtonLayout:{
    marginVertical:8,
  },
  tertiaryButton: {

  },
  tertiaryButtonText: {
    textAlign:'center',
    margin:16,
    fontSize:16,
    fontWeight:'bold',
    textDecorationLine:'underline',
  },
  buttonShadow: {
    shadowColor:'#000',
    shadowOffset:{width:2, height:2},
    shadowOpacity:0.5,
    shadowRadius: 2,
  },
  
  alertContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
  },
  alertBox: {
    backgroundColor: '#FFF',
    padding: 20,
    borderRadius: 10,
    alignItems: 'center',
    elevation: 5,
  },
  alertText: {
    fontSize: 16,
    marginBottom: 20,
    textAlign: 'center',
  },
  alertButtonContainer: {
    flexDirection: 'column',
    width: '200%',
    alignItems: 'center',
  },
  alertButton: {
    width: '100%',
    paddingVertical: 20,
    borderRadius: 10,
    marginVertical: 10,
    alignItems: 'center',
    justifyContent: 'center',
  },
  alertButtonText: {
    color: '#FFF',
    fontWeight: 'bold',
    textAlign: 'center',
  },
  changeConditionsButton: {
    backgroundColor: '#08546C', // 再生成・条件変更ボタンの色
    paddingHorizontal:100
  },
  abortButton: {
    backgroundColor: '#08546C', // 中断ボタンの色
    paddingVertical: 20,
    paddingHorizontal:100
  },
  cancelButton: {
    backgroundColor: '#A0BACC', // キャンセルボタンの色
  },




  title:{
    fontSize:24,
    fontWeight:'regular',
    fontFamily:'Hiragino Mincho ProN',
    color:"#999999",
    marginBottom:8,
    marginLeft:4,
  },
  goal:{
    fontSize:48,
    fontWeight:'bold',
    color:"#333333",
    marginLeft:24,
  },
  address:{
    fontSize:16,
    fontWeight:'regular',
    color:'#444444',
    marginTop:8,
    marginLeft:28,
  },
  route:{
    fontSize:28,
    fontWeight:'bold',
    color:"#333333",
    marginTop:24,
    marginLeft:28,
  },
  movetool:{
    fontSize:24,
    fontWeight:'regular',
    color:"#333333",
    marginTop:16,
    marginLeft:32,
  },
  movetoolmin:{
    fontSize:16,
    fontWeight:'regular',
    color:"#333333",
    marginTop:16,
    marginLeft:58,
  },

});

export default SearchScreen;
