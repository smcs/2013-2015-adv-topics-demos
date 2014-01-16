//
//  GLViewController.m
//  OpenGL 01.++ Three Cuboid Objects
//
//  Created by Seth Battis on 3/9/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import "GLViewController.h"
#import "ConstantsAndMacros.h"
#import "OpenGLCommon.h"
#import "RedCubeUnion.h"
#import "YellowCube.h"
#import "BlueCube.h"

@implementation GLViewController
- (void)drawView:(UIView *)theView
{
    glColor4f(0.0, 0.0, 0.0, 0.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
	glLoadIdentity();
	gluLookAt(0, 0, 10, 0, 0, 0, 0, 1, 0);
	spin++;
	glRotatef(spin, 0, 1, 0);
	
	
	glPushMatrix();
	{
		glScalef(0.5, 0.5, 0.5);
		glPushMatrix();
		{
			glColor4f(1, 0, 0, 1);
			glTranslatef(1.481, 1.282, 1.378);
			drawRedCubeUnion();
		}
		glPopMatrix();
		
		glPushMatrix();
		{
			glColor4f(1, 1, 0, 1);
			glTranslatef(-1.171, -2.671, 2.802);
			drawYellowCube();
		}
		glPopMatrix();
	}
	glPopMatrix();
	
	glPushMatrix();
	{
		glColor4f(0, 0, 1, 1);
		glTranslatef(2.996, -3.953, -1.274);
		drawBlueCube();
	}
	glPopMatrix();
}
-(void)setupView:(GLView*)view
{
	const GLfloat zNear = 0.01, zFar = 1000.0, fieldOfView = 45.0; 
	GLfloat size; 
	glEnable(GL_DEPTH_TEST);
	glMatrixMode(GL_PROJECTION); 
	size = zNear * tanf(DEGREES_TO_RADIANS(fieldOfView) / 2.0); 
	CGRect rect = view.bounds; 
	glFrustumf(-size, size, -size / (rect.size.width / rect.size.height), size / 
			   (rect.size.width / rect.size.height), zNear, zFar); 
	glViewport(0, 0, rect.size.width, rect.size.height);  
	glMatrixMode(GL_MODELVIEW);
	
	glLoadIdentity();	
}
- (void)dealloc 
{
    [super dealloc];
}
@end
