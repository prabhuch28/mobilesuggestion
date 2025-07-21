# Deployment Guide - Phone Suggester

Quick deployment instructions for the Phone Suggester application.

## Backend Deployment (Render.com)

### Step 1: Prepare Your Code
1. Make sure your code is pushed to GitHub
2. Ensure `pom.xml` is in the root directory
3. Verify `application.properties` has proper MongoDB configuration

### Step 2: Deploy on Render
1. Go to [render.com](https://render.com) and sign up/login
2. Click "New +" → "Web Service"
3. Connect your GitHub repository
4. Configure the service:
   - **Name**: `phone-suggester-backend`
   - **Build Command**: `mvn clean package -DskipTests`
   - **Start Command**: `java -jar target/phone-suggester-0.0.1-SNAPSHOT.jar`
   - **Environment**: Java

### Step 3: Environment Variables
Add these environment variables in Render:
- `MONGODB_URI`: Your MongoDB Atlas connection string
- `PORT`: `8080`

### Step 4: Deploy
Click "Create Web Service" and wait for deployment.

## Frontend Deployment (Netlify)

Since the frontend is served from the Spring Boot application, you have two options:

### Option 1: Deploy Frontend Separately (Recommended)
1. Extract the frontend code from `src/main/resources/static/index.html`
2. Create a separate React project
3. Deploy to Netlify:
   - Go to [netlify.com](https://netlify.com)
   - Drag and drop your frontend folder
   - Or connect your GitHub repository

### Option 2: Use the Backend URL
- Your frontend is already deployed with the backend
- Access it at: `https://your-render-app.onrender.com`

## MongoDB Setup (MongoDB Atlas)

### Step 1: Create MongoDB Atlas Account
1. Go to [mongodb.com/atlas](https://mongodb.com/atlas)
2. Sign up for a free account
3. Create a new cluster (free tier)

### Step 2: Configure Database
1. Create a database user
2. Get your connection string
3. Add it to Render environment variables

### Step 3: Update Application Properties
```properties
spring.data.mongodb.uri=${MONGODB_URI}
```

## Testing Your Deployment

1. **Backend API**: `https://your-app.onrender.com/api/v1/phones`
2. **Frontend**: `https://your-app.onrender.com`
3. **API Docs**: `https://your-app.onrender.com/swagger-ui.html`

## Common Issues

### Build Failures
- Check Maven dependencies in `pom.xml`
- Ensure Java 21 is specified
- Verify all imports are correct

### Database Connection
- Check MongoDB Atlas network access (allow all IPs: 0.0.0.0/0)
- Verify connection string format
- Ensure database user has proper permissions

### CORS Issues
- Frontend and backend should be on same domain
- Or configure CORS properly in `SecurityConfig.java`

## Quick Commands

```bash
# Local testing
mvn clean package -DskipTests
java -jar target/phone-suggester-0.0.1-SNAPSHOT.jar

# Check if app is running
curl http://localhost:8080/api/v1/phones
```

## Support

For deployment issues:
1. Check Render logs in the dashboard
2. Verify environment variables
3. Test locally first
4. Check MongoDB connection

---

**Your app should be live in 10-15 minutes!** 🚀 

---

Thank you for sharing! If you have **Java 23** installed, but your Maven build is failing with `invalid target release: 21`, it usually means:

- Maven is not using your Java 23 installation (it might be using an older version).
- Or, your `pom.xml` is set to use Java 21, but Java 23 is fully compatible and should work.

---

## 🔍 **How to Fix**

### 1. **Check What Java Maven is Using**
Run:
```bash
mvn -v
```
- The output should show `Java version: 23...`
- If it shows an older version, Maven is not using Java 23.

---

### 2. **If Maven is NOT using Java 23**
You need to set your `JAVA_HOME` to point to Java 23.

**On Mac/Linux:**
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 23)
export PATH=$JAVA_HOME/bin:$PATH
```
Add these lines to your `~/.zshrc` or `~/.bashrc` to make it permanent.

**On Windows:**
- Set the `JAVA_HOME` environment variable to your Java 23 install directory.
- Add `%JAVA_HOME%/bin` to your `Path`.

---

### 3. **Try Building Again**
```bash
mvn clean package -DskipTests
```

---

### 4. **If You Still Get the Error**
- Make sure your `pom.xml` has:
  ```xml
  <java.version>23</java.version>
  ```
  or
  ```xml
  <java.version>23</java.version>
  ```
- Java 23 can compile code for Java 21, but Maven must use the correct JDK.

---

## ⚡️ **Summary**
- Make sure Maven is using Java 23 (`mvn -v` should show Java 23).
- Set `JAVA_HOME` to Java 23 if needed.
- Try building again.

---

**If you run `mvn -v` and paste the output here, I can give you the exact next step!** 