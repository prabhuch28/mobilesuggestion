# 🚀 Phone Suggester - Deployment Guide

## 🌐 **Live Application Links**

Your application is now ready for deployment! Here are the deployment options:

### **Option 1: Render.com (Recommended - FREE)**
1. Go to [https://render.com](https://render.com)
2. Sign up/Login with your GitHub account
3. Click "New +" → "Web Service"
4. Connect your GitHub repository: `prabhuch28/mobilesuggestion`
5. Configure:
   - **Name**: `phone-suggester-api`
   - **Environment**: `Java`
   - **Build Command**: `mvn clean package -DskipTests`
   - **Start Command**: `java -jar target/phone-suggester-0.0.1-SNAPSHOT.jar`
   - **Plan**: Free
6. Click "Create Web Service"
7. Wait for deployment (5-10 minutes)

**Your app will be available at**: `https://phone-suggester-api.onrender.com`

### **Option 2: Railway.app (FREE)**
1. Go to [https://railway.app](https://railway.app)
2. Sign up/Login with your GitHub account
3. Click "New Project" → "Deploy from GitHub repo"
4. Select your repository: `prabhuch28/mobilesuggestion`
5. Railway will automatically detect it's a Java app
6. Deploy automatically

**Your app will be available at**: `https://your-app-name.railway.app`

### **Option 3: Heroku (FREE)**
1. Install Heroku CLI: `brew install heroku/brew/heroku`
2. Login: `heroku login`
3. Create app: `heroku create phone-suggester-app`
4. Deploy: `git push heroku main`
5. Open: `heroku open`

**Your app will be available at**: `https://phone-suggester-app.herokuapp.com`

## 📋 **API Endpoints**

Once deployed, your API will be available at:

- **Base URL**: `https://your-app-url.com`
- **API Documentation**: `https://your-app-url.com/swagger-ui.html`
- **Health Check**: `https://your-app-url.com/api/v1/phones`

### **Available Endpoints:**
- `GET /api/v1/phones` - Get all phones
- `GET /api/v1/phones/{id}` - Get phone by ID
- `GET /api/v1/phones/search?query={term}` - Search phones
- `GET /api/v1/phones/brand/{brand}` - Get phones by brand
- `GET /api/v1/phones/type/{type}` - Get phones by usage type
- `GET /api/v1/phones/price-range?minPrice={min}&maxPrice={max}` - Get phones by price range

## 🎯 **Quick Test**

After deployment, test your API:

```bash
# Test the API
curl https://your-app-url.com/api/v1/phones

# Test search
curl https://your-app-url.com/api/v1/phones/search?query=iPhone

# Test brand filter
curl https://your-app-url.com/api/v1/phones/brand/Apple
```

## 🔧 **Local Development**

To run locally:

```bash
cd phone-suggester-maven
mvn clean spring-boot:run
```

Access at: `http://localhost:8081`

## 📁 **Project Structure**

```
phone-suggester-maven/
├── src/main/java/com/example/phonesuggester/
│   ├── controller/PhoneController.java
│   ├── service/InMemoryPhoneService.java
│   ├── model/Phone.java
│   ├── dto/
│   ├── config/
│   └── exception/
├── src/main/resources/
│   ├── application.properties
│   └── static/
├── pom.xml
├── render.yaml
├── Procfile
└── system.properties
```

## 🎉 **Success!**

Your Phone Suggester application is now:
- ✅ Modernized with Spring Boot 3.2.5
- ✅ Running with in-memory data (no external dependencies)
- ✅ Ready for deployment
- ✅ Includes comprehensive API documentation
- ✅ Has proper error handling and validation

**Next Steps:**
1. Deploy using one of the options above
2. Share your deployed URL
3. Test all API endpoints
4. Enjoy your modern phone suggestion app! 🚀 