<template>
<div class="m-0 p-0 background">
  <div class="container">
    <div class="container-fluid">
      <div class="title">
        <p class="lg-title">
          실제<span class="owo-text"> #오운완 </span>을 사용하시는 회원님입니다.
        </p>
      </div>
      <div class="carousel">
        <Carousel :autoplay="4000" :items-to-show="4" :wrap-around="true">
          <Slide v-for="(image, i) in images" :key="i" style="padding: 25px; border-radius: 10px;">
            <div class="carousel__item"><img :src="image" alt="운동이미지"
            style="width: 100%; height: 100%; border-radius: 20px;"></div>
          </Slide>
          <template #addons>
            <Pagination />
          </template>
        </Carousel>
        <!-- <div v-for="(image, i) in images" :key="i">
        <img :src="image" alt="">
        </div> -->
      </div>
        <div class="content">
          <h1 class="h1-rem">
            <span class="blue">운동 사진</span>을 찍어 나만의 <span class="blue">캘린더</span>에 보관하세요!</h1>
          <!-- <p class="first-intro-text fs-4">오운완과 함께 하신 회원님들입니다!</p> -->
          <p class="text">오운완을 통해 운동하면 편하게 운동 사진을 보관할 수 있어요.</p>
          <p class="text">최근 사진들은 메인 화면에 자랑할 수 있답니다!</p>
          <p class="text">이제부터는 번거롭게 인증사진을 찍으러 갈 필요가 없어요!</p>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import { reactive, computed } from 'vue';
import { Carousel, Pagination, Slide } from 'vue3-carousel';
import { useStore } from 'vuex';
import axios from 'axios';

import 'vue3-carousel/dist/carousel.css';

export default ({
  name: 'AutoPlay',
  components: {
    Carousel,
    Slide,
    Pagination,
  },
  setup() {
    const store = useStore();
    const isLogin = computed(() => store.getters['accounts/isLogin']);
    const state = reactive({
    });
    return {
      state,
      isLogin,
    };
  },
  data() {
    return {
      images: [],
    };
  },
  created() {
    this.getImage();
  },
  methods: {
    async getImage() {
      await axios({
        url: 'https://i7c202.p.ssafy.io:8282/api/record/img/main',
        method: 'get',
      })
        .then((res) => {
          console.log('이미지 불러오는 중');
          console.log(res);
          const url = 'https://i7c202.p.ssafy.io:8282';
          // eslint-disable-next-line
          for (let i = 0; i < res.data.data.length; i += 1) {
            this.images.push(url.concat(res.data.data[i].fileUrl));
            // this.images[i] = this.images[i].replace(',', '_');
            console.log(this.images[i]);
          }
          console.log('이미지 가져오기 성공.');
        })
        .catch((err) => {
          console.log('이미지 가져오기 실패');
          console.log(err);
        });
    },
  },
});
</script>

<style scoped>
.background {
  /* background-color:#642AFB; */
  /* background-color:#DFDFDF; */
}
  .container {
    min-width: 80vw;
  }
    .container-fluid {
      padding-top: 30px;
      height: 100vh;
    }
.title {
  font-family: 'Recipekorea';
  margin-top: 3vh;
}

.owo-text {
  color: #642AFB;
  font-size: 3vh;;
}
.content {
  padding: 1.2em;
  height: 40vh;
}
.h1-rem {
  font-size: 4.5vh;
  /* padding: 2vh; */
  font-family: 'Recipekorea';
  color: black;
  padding-bottom: 20px;
}
.h1-rem2 {
  font-size: 6vh;
  padding: 2vh;
  font-family: 'Recipekorea';
  color: black;
  text-decoration: none;
  text-shadow: 5px 5px #4E8AFF;
}
.h1-rem2:hover {
  text-shadow: 5px 5px #7499e2;
  top: -2px;
}
.text {
  font-size: 2vh;
  line-height: 1.2vh;
  padding: 0.5em;
}
.lg-title {
  font-weight: 800;
  font-size: 2.5vh;
  text-align: left;
}

.carousel {
  /* padding-top: 10px; */
  padding-bottom: 10px;
}
.carousel__item {
  /* min-height: 300px; */
  height: 37vh;
  width: 99%;
  /* background-color: var(--vc-clr-primary); */
  color:  var(--vc-clr-white);
  font-size: 20px;
  border-radius: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
  /* border-radius: 20px; */
}

.carousel__prev,
.carousel__next {
  box-sizing: content-box;
  /* border: 5px solid white; */
}
.blue {
  color: #4E8AFF;
  font-weight: bold;
}
.start-btn {
  font-family: 'yg-jalnan';
  margin-top: 1vh;
  width: 200px;
  height: 50px;
  color: #fff;
  border-radius: 30px;
  padding: 10px 25px;
  /* font-family: 'Lato', sans-serif; */
  font-weight: 400;
  font-size: 20px;
  background: transparent;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
  box-shadow:inset
    2px 2px 2px 0px rgba(255,255,255,.5),
    7px 7px 20px 0px rgba(0,0,0,.1),
    4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
}

.btn-12{
  position: relative;
  right: 20px;
  bottom: 20px;
  border:none;
  box-shadow: none;
  width: 200px;
  height: 50px;
  line-height: 45px;
  -webkit-perspective: 230px;
  perspective: 230px;
}
.btn-12 span {
  background: rgb(0,172,238);
  background: linear-gradient(0deg, rgb(191, 180, 231) 0%, rgb(87, 42, 251) 100%);
  display: block;
  position: absolute;
  width: 200px;
  height: 50px;
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
    7px 7px 20px 0px rgba(0,0,0,.1),
    4px 4px 5px 0px rgba(0,0,0,.1);
  border-radius: 20px;
  margin:0;
  text-align: center;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all .3s;
  transition: all .3s;
}
.btn-12 span:nth-child(1) {
  box-shadow:
    -7px -7px 20px 0px #fff9,
    -4px -4px 5px 0px #fff9,
    7px 7px 20px 0px #0002,
    4px 4px 5px 0px #0001;
  -webkit-transform: rotateX(90deg);
  -moz-transform: rotateX(90deg);
  transform: rotateX(90deg);
  -webkit-transform-origin: 50% 50% -20px;
  -moz-transform-origin: 50% 50% -20px;
  transform-origin: 50% 50% -20px;
}
.btn-12 span:nth-child(2) {
  -webkit-transform: rotateX(0deg);
  -moz-transform: rotateX(0deg);
  transform: rotateX(0deg);
  -webkit-transform-origin: 50% 50% -20px;
  -moz-transform-origin: 50% 50% -20px;
  transform-origin: 50% 50% -20px;
}
.btn-12:hover span:nth-child(1) {
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
    7px 7px 20px 0px rgba(0,0,0,.1),
    4px 4px 5px 0px rgba(0,0,0,.1);
  -webkit-transform: rotateX(0deg);
  -moz-transform: rotateX(0deg);
  transform: rotateX(0deg);
}
.btn-12:hover span:nth-child(2) {
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
    7px 7px 20px 0px rgba(0,0,0,.1),
    4px 4px 5px 0px rgba(0,0,0,.1);
  color: transparent;
  -webkit-transform: rotateX(-90deg);
  -moz-transform: rotateX(-90deg);
  transform: rotateX(-90deg);
}
.btn-12:active {
  top:-16px;
}
.carousel__slide > .carousel__item {
  transform: scale(1);
  opacity: 0.5;
  transition: 0.5s;
}
.carousel__slide--visible > .carousel__item {
  opacity: 1;
  transform: rotateY(0);
}
.carousel__slide--next > .carousel__item {
  transform: scale(0.9) translate(-10px);
}
.carousel__slide--prev > .carousel__item {
  transform: scale(0.9) translate(10px);
}
.carousel__slide--active > .carousel__item {
  transform: scale(1.1);
}
</style>
