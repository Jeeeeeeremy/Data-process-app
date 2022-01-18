module.exports = {
	publicPath: process.env.NODE_ENV === 'development' ? '/community-chat': './',
	devServer:{
		proxy:{
			'/api':{
				target:'http://localhost:8080/demo_war_exploded/',
				changeOrigin:true,
				pathRewrite:{
					'^/api':'/'
				}
			}
		}
	}
}