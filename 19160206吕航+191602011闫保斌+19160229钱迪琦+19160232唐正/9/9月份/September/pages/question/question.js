Page({
  data:{
    keyboardInputValue:null
  },

  bindCommentInput: function (event) {
    var val = event.detail.value;
    this.data.keyboardInputValue = val;
  },

  submit:function(event){
    if (this.data.keyboardInputValue == null || this.data.keyboardInputValue==""){
      wx.showToast({
        title: '请输入问题',
        icon:'none'
      })
      return;
    }
    var utils=require('../../utils/util.js');
    utils.refreshQA(this.data.keyboardInputValue);
    wx.navigateTo({
      url: '../answer/answer'
    })
  }

})