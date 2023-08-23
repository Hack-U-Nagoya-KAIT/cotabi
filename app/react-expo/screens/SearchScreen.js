import { LinearGradient } from 'expo-linear-gradient';
import React from 'react';
import { TouchableOpacity, Button, StyleSheet, Text, View, ScrollView } from 'react-native';
import MaskedView from '@react-native-masked-view/masked-view';

const SearchScreen = ({ navigation, route }) => {
  const { budget, timeRequired, concept } = route.params;

  const handleSavePlan = () => {
    // プランの保存処理
  };

  const handleChangeConditions = () => {
    // 条件変更処理
  };

  const handleRegenerate = () => {
    // 再生成処理
  };

  const handleAbort = () => {
    // 生成中断処理
  };

  return (
    <View style={styles.container} >
      <View style = {[{flex:2}, {alignSelf:'stretch'}]}>
        {/* <Text>検索結果</Text>
        <Text>予算: {budget}円</Text>
        <Text>所要時間: {timeRequired}分</Text>
        <Text>コンセプト: {concept}</Text> */}
        <ScrollView style = {styles.outputScrollView} showsVerticalScrollIndicator = {true}>
          <Text style = {styles.outputText}>Hello, World! Nice to meet you! This is OutputText and ScrollView!</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
        </ScrollView>
      </View>
      <View style = {[{flex:1}, {alignSelf:'stretch'}]}>  
        <TouchableOpacity title="しおりを保存" style = {[styles.primaryButtonLayout, styles.buttonShadow]} onPress={handleSavePlan}>
          <LinearGradient colors={['#022534', '#08546C', '#A0BACC']} 
            start={{x:0.0, y:0.5}}
            end={{x:1.0, y:0.5}}
            style={styles.primaryButton}>
            <Text style = {styles.primaryButtonText}>しおりを保存</Text>
          </LinearGradient>
        </TouchableOpacity>
        <TouchableOpacity title="条件変更・再生成" style = {[styles.secondaryButtonLayout, styles.buttonShadow]} onPress={handleChangeConditions}>
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
  }
  
});

export default SearchScreen;
