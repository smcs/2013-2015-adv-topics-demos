//
//  GLViewController.m
//  Monkey
//
//  Created by Seth Battis on 3/7/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import "GLViewController.h"
#import "ConstantsAndMacros.h"
#import "OpenGLCommon.h"
#import "Monkey.h"

@implementation GLViewController
- (void)drawView:(UIView *)theView
{
    glColor4f(0.0, 0.0, 0.0, 0.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
	// Drawing Code:
	spin += 0.01;
	
	float x = sin(spin) * 4;
	float z = cos(spin) * 4;
	
	glLoadIdentity();
	gluLookAt(x, 0, z, 0, 0, 0, 0, 1, 0);

	glEnableClientState(GL_VERTEX_ARRAY);
	glEnableClientState(GL_COLOR_ARRAY);
	glEnable(GL_COLOR_MATERIAL);
	glEnableClientState(GL_NORMAL_ARRAY);
	glVertexPointer(3, GL_FLOAT, sizeof(ColoredVertexData3D), &SuzanneVertexData[0].vertex);
	glNormalPointer(GL_FLOAT, sizeof(ColoredVertexData3D), &SuzanneVertexData[0].normal);
	glColorPointer(4, GL_FLOAT, sizeof(ColoredVertexData3D), &SuzanneVertexData[0].color);
	glDrawArrays(GL_TRIANGLES, 0, kSuzanneNumberOfVertices);
	glDisableClientState(GL_VERTEX_ARRAY);
	glDisableClientState(GL_NORMAL_ARRAY);
	glDisable(GL_COLOR_MATERIAL);
	glDisableClientState(GL_NORMAL_ARRAY);    
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
	
	glEnable(GL_LIGHT0);
	glEnable(GL_LIGHTING);
	
	glLoadIdentity(); 
}
- (void)dealloc 
{
    [super dealloc];
}
@end
