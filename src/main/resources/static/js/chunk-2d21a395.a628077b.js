(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21a395"],{bb32:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("h1",{staticClass:"mb-0"},[t._v("Sign in")]),s("p",[t._v("输入您的电子邮件地址和密码，以访问管理面板")]),s("p",[t._v("//登录账号对应数据库")]),s("tab-nav",{staticClass:"nav-fill mb-3",attrs:{pills:!0,id:"pills-tab-1"}}),s("tab-content",{staticClass:"mt-0",attrs:{id:"pills-tabContent-1"}},[s("tab-content-item",{attrs:{active:!0,id:"pills-jwt-fill","aria-labelled-by":"pills-jwt-tab-fill"}},[s("sign-in1-form",{attrs:{formType:"jwt",username:"admin",password:"123456"}})],1)],1)],1)},r=[],n=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("ValidationObserver",{ref:"form",scopedSlots:t._u([{key:"default",fn:function(e){var a=e.handleSubmit;return[s("form",{staticClass:"mt-4",attrs:{novalidate:""},on:{submit:function(e){return e.preventDefault(),a(t.onSubmit)}}},[s("ValidationProvider",{scopedSlots:t._u([{key:"default",fn:function(e){var a=e.errors;return[s("div",{staticClass:"form-group"},[s("label",{attrs:{for:"emailInput"}},[t._v("Username")]),s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.username,expression:"user.username"}],class:"form-control mb-0"+(a.length>0?" is-invalid":""),attrs:{type:"text",id:"emailInput","aria-describedby":"emailHelp",autocomplete:"",placeholder:"Username",required:""},domProps:{value:t.user.username},on:{input:function(e){e.target.composing||t.$set(t.user,"username",e.target.value)}}}),s("div",{staticClass:"invalid-feedback"},[s("span",[t._v(t._s(a[0]))])])])]}}],null,!0)}),s("ValidationProvider",{attrs:{vid:"password",name:"Password",rules:"required"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.errors;return[s("div",{staticClass:"form-group"},[s("label",{attrs:{for:"passwordInput"}},[t._v("Password")]),s("a",{staticClass:"float-right",on:{click:t.btn}},[t._v(" 忘记密码 ？ ")]),s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.password,expression:"user.password"}],class:"form-control mb-0"+(a.length>0?" is-invalid":""),attrs:{type:"password",id:"passwordInput",autocomplete:"",placeholder:"Password",required:""},domProps:{value:t.user.password},on:{input:function(e){e.target.composing||t.$set(t.user,"password",e.target.value)}}}),s("div",{staticClass:"invalid-feedback"},[s("span",[t._v(t._s(a[0]))])])])]}}],null,!0)}),s("div",{staticClass:"d-inline-block w-100"},[s("div",{staticClass:"custom-control custom-checkbox d-inline-block mt-2 pt-1"},[s("input",{staticClass:"custom-control-input",attrs:{type:"checkbox",id:t.formType}}),s("label",{staticClass:"custom-control-label",attrs:{for:t.formType}},[t._v("记住我")])]),s("button",{staticClass:"btn btn-primary float-right",attrs:{type:"submit"}},[t._v("Sign in")])]),s("div",{staticClass:"sign-info",staticStyle:{display:"none"}},[s("span",{staticClass:"dark-color d-inline-block line-height-2"},[t._v(" Don't have an account? "),s("router-link",{staticClass:"iq-waves-effect pr-4",attrs:{to:"/auth/sign-up1"}},[t._v(" Sign up ")])],1)])],1)]}}])})},o=[],i=s("1da1"),l=(s("96cf"),s("6bf2")),u=s("0d1c"),c=s.n(u),d={name:"SignIn1Form",props:["formType","username","password"],data:function(){return{user:{username:"",password:""}}},mounted:function(){this.user.username=this.$props.username,this.user.password=this.$props.password},computed:{},methods:{btn:function(){c.a.show({text:"找不回了重新注册吧",backgroundColor:"#323232"})},onSubmit:function(){"jwt"===this.formType?this.jwtLogin():c.a.show({text:"出现了问题 我也不知道是什么问题",backgroundColor:"#323232"})},jwtLogin:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){var s,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,l["a"].login(t.user);case 2:if(s=e.sent,a=s.data,200!==a.code){e.next=10;break}return localStorage.setItem("user",a.data.user),localStorage.setItem("access_token",a.data.JWT),t.$store.dispatch("Setting/addUserAction",t.user),e.next=10,t.$router.push({name:"dashboard.home-1"});case 10:c.a.show({text:a.msg,backgroundColor:"#323232"});case 11:case"end":return e.stop()}}),e)})))()}}},p=d,m=s("2877"),f=Object(m["a"])(p,n,o,!1,null,null,null),v=f.exports,b={name:"SignIn1",components:{SignIn1Form:v},mounted:function(){var t=localStorage.getItem("access_token");void 0!==t&&null!==t&&this.$router.push({name:"mini.dashboard.home-2"})}},h=b,w=Object(m["a"])(h,a,r,!1,null,null,null);e["default"]=w.exports}}]);