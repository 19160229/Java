// pages/answer/answer.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    answers:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var app=getApp();
    this.setData({
      answers:app.globalData.answer
    });
  },
})