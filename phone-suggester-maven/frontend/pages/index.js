import Image from 'next/image';

export default function Home() {
  return (
    <div className="bg-gradient-to-br from-blue-50 via-purple-50 to-teal-50 min-h-screen font-sans">
      {/* Hero Section */}
      <section className="flex flex-col items-center justify-center py-12">
        <div className="relative w-40 h-40 mb-6 rounded-2xl overflow-hidden shadow-xl border-4 border-blue-200">
          <Image
            src="/profile.jpg"
            alt="Prabhu Chaturvedi"
            layout="fill"
            objectFit="cover"
            className="rounded-2xl"
          />
        </div>
        <h1 className="text-4xl font-bold text-blue-900 mb-2">Prabhu Chaturvedi</h1>
        <h2 className="text-xl text-purple-700 font-semibold mb-4">App Developer & Researcher</h2>
        <p className="max-w-xl text-center text-gray-700 text-lg">
          Turning ideas into impactful solutions. Passionate about building modern apps, exploring new tech, and solving real-world problems with code.
        </p>
      </section>

      {/* About Me */}
      <section className="max-w-2xl mx-auto my-10 bg-white/80 rounded-xl shadow-md p-8">
        <h3 className="text-2xl font-bold text-blue-800 mb-4">About Me</h3>
        <p className="text-gray-800 text-lg">
          Hi! I’m Prabhu Chaturvedi, a dedicated app developer and tech enthusiast. I enjoy working on innovative projects, from mobile apps to backend systems. My journey is driven by curiosity, creativity, and a desire to make technology accessible and useful for everyone. I thrive in collaborative environments and love learning new things every day.
        </p>
      </section>

      {/* Skills Section */}
      <section className="max-w-4xl mx-auto my-10">
        <h3 className="text-2xl font-bold text-blue-800 mb-6">Skills</h3>
        <div className="grid md:grid-cols-3 gap-4">
          <div className="bg-white/90 rounded-lg shadow p-4">Java, Spring Boot, REST APIs</div>
          <div className="bg-white/90 rounded-lg shadow p-4">React, JavaScript, TypeScript</div>
          <div className="bg-white/90 rounded-lg shadow p-4">MongoDB, MySQL, SQL</div>
          <div className="bg-white/90 rounded-lg shadow p-4">Android (Java/Kotlin)</div>
          <div className="bg-white/90 rounded-lg shadow p-4">Git, GitHub, VS Code</div>
          <div className="bg-white/90 rounded-lg shadow p-4">Postman, API Integration</div>
        </div>
      </section>

      {/* Projects */}
      <section className="max-w-4xl mx-auto my-10">
        <h3 className="text-2xl font-bold text-blue-800 mb-6">Projects</h3>
        <div className="grid md:grid-cols-3 gap-6">
          {/* Project 1 */}
          <div className="bg-white/90 rounded-lg shadow p-6 flex flex-col">
            <h4 className="font-semibold text-lg text-purple-700 mb-2">KaryaSahayak - Smart HR Helpdesk</h4>
            <p className="text-gray-700 flex-1 mb-2">A smart HR helpdesk system with React, TypeScript, Spring Boot & MongoDB. Streamlines HR queries and automates support for organizations.</p>
            <a href="https://github.com/prabhuch28/karyasahayak-hr-helpdesk" target="_blank" rel="noopener noreferrer" className="text-blue-600 hover:underline font-medium">View on GitHub</a>
          </div>
          {/* Project 2 */}
          <div className="bg-white/90 rounded-lg shadow p-6 flex flex-col">
            <h4 className="font-semibold text-lg text-purple-700 mb-2">Pizzabill</h4>
            <p className="text-gray-700 flex-1 mb-2">A simple pizza billing web app. Demonstrates clean UI, basic logic, and fun user experience for learning and demos.</p>
            <a href="https://github.com/prabhuch28/Pizzabill" target="_blank" rel="noopener noreferrer" className="text-blue-600 hover:underline font-medium">View on GitHub</a>
          </div>
          {/* Project 3 */}
          <div className="bg-white/90 rounded-lg shadow p-6 flex flex-col">
            <h4 className="font-semibold text-lg text-purple-700 mb-2">Modern Phone Recommendation App</h4>
            <p className="text-gray-700 flex-1 mb-2">A full-stack app to recommend smartphones based on user preferences. Built with Spring Boot and React, featuring authentication and search.</p>
            <a href="https://github.com/prabhuch28/phone-suggester-app" target="_blank" rel="noopener noreferrer" className="text-blue-600 hover:underline font-medium">View on GitHub</a>
          </div>
        </div>
      </section>

      {/* Education Section */}
      <section className="max-w-4xl mx-auto my-10">
        <h3 className="text-2xl font-bold text-blue-800 mb-6">Education</h3>
        <div className="bg-white/90 rounded-lg shadow p-6">
          <h4 className="font-semibold text-lg text-purple-700">Bachelor of Technology in Computer Science</h4>
          <span className="text-gray-600">XYZ University • 2020 - 2024</span>
          <p className="text-gray-700 mt-2">Relevant coursework: Data Structures, Algorithms, Web Development, Mobile App Development, Databases.</p>
        </div>
      </section>

      {/* Testimonials Section */}
      <section className="max-w-4xl mx-auto my-10">
        <h3 className="text-2xl font-bold text-blue-800 mb-6">Testimonials</h3>
        <div className="bg-white/90 rounded-lg shadow p-6 mb-4">
          <p className="text-gray-800 italic">“Prabhu is a quick learner and a dedicated developer. He brings creativity and energy to every project.”</p>
          <span className="block text-right text-gray-600 mt-2">— Mentor, Tech Company</span>
        </div>
        <div className="bg-white/90 rounded-lg shadow p-6">
          <p className="text-gray-800 italic">“A great team player and problem solver. Highly recommend for any tech project!”</p>
          <span className="block text-right text-gray-600 mt-2">— Peer, University Project</span>
        </div>
      </section>

      {/* Contact */}
      <section className="max-w-2xl mx-auto my-10 bg-white/80 rounded-xl shadow-md p-8">
        <h3 className="text-2xl font-bold text-blue-800 mb-4">Contact</h3>
        <div className="flex flex-wrap gap-4 mb-6">
          <a href="https://www.linkedin.com/in/prabhu-chaturvedi-491563247/" target="_blank" rel="noopener noreferrer" className="bg-blue-600 text-white px-4 py-2 rounded-lg font-medium hover:bg-blue-700">LinkedIn</a>
          <a href="https://github.com/prabhuch28" target="_blank" rel="noopener noreferrer" className="bg-gray-900 text-white px-4 py-2 rounded-lg font-medium hover:bg-gray-800">GitHub</a>
          <a href="mailto:your.email@example.com" className="bg-teal-500 text-white px-4 py-2 rounded-lg font-medium hover:bg-teal-600">Email</a>
        </div>
        <form className="flex flex-col gap-4">
          <input type="text" placeholder="Your Name" className="border rounded-lg p-2" />
          <input type="email" placeholder="Your Email" className="border rounded-lg p-2" />
          <textarea placeholder="Your Message" className="border rounded-lg p-2" rows={4}></textarea>
          <button type="submit" className="bg-blue-600 text-white px-4 py-2 rounded-lg font-medium hover:bg-blue-700">Send Message</button>
        </form>
      </section>
    </div>
  );
} 